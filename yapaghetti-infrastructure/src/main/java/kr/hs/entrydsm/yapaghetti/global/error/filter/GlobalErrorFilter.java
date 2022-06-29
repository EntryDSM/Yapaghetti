package kr.hs.entrydsm.yapaghetti.global.error.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.hs.entrydsm.yapaghetti.error.ErrorProperty;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;
import kr.hs.entrydsm.yapaghetti.global.error.ErrorResponse;
import kr.hs.entrydsm.yapaghetti.global.error.GlobalErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class GlobalErrorFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (YapaghettiException e) {
            setErrorResponse(e.getErrorProperty(), response);
        } catch (Exception e) {
            if (e.getCause() instanceof YapaghettiException yapaghettiException) {
                setErrorResponse(yapaghettiException.getErrorProperty(), response);
            } else {
                setErrorResponse(GlobalErrorCode.INTERNAL_SERVER_ERROR, response);
            }
        }
    }

    private void setErrorResponse(ErrorProperty errorProperty, HttpServletResponse response) throws IOException {
        response.setStatus(errorProperty.getStatus());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(
                objectMapper.writeValueAsString(
                        new ErrorResponse(errorProperty)
                )
        );
    }
}
