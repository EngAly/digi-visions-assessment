package com.digivisions.assessment.managingfiles.config;

import com.digivisions.assessment.managingfiles.dto.GenericResponse;
import com.digivisions.assessment.managingfiles.enums.ResponseStatus;
import com.digivisions.assessment.managingfiles.service.PermissionService;
import com.digivisions.assessment.utils.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
public class JwtFilter extends OncePerRequestFilter {

    private final PermissionService permissionService;

    public JwtFilter(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String username = request.getHeader("Authorization");
            setUserDetails(username);
            filterChain.doFilter(request, response);
        } catch (Exception exception) {
            setResponseError(response, exception);
        }
    }


    private void setUserDetails(String username) {

        boolean isUserExist = permissionService.existsByUsername(username);

        if (!isUserExist) throw new SecurityException("Username not exists");

        ContextStorage.setUsername(username);
    }


    public void setResponseError(HttpServletResponse response, Exception exception) throws IOException {

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        GenericResponse genericResponse = new GenericResponse(ResponseStatus.FAIL, exception.getMessage());
        response.getWriter().write(StringUtils.mapJsonToString(genericResponse));
    }
}
