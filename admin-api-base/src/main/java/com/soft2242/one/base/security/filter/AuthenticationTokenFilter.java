package com.soft2242.one.base.security.filter;

import com.soft2242.one.base.security.cache.TokenStoreCache;
import com.soft2242.one.base.security.user.UserDetail;
import com.soft2242.one.base.security.utils.TokenUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * 认证过滤器
 *
 * @author moqi
 */
@Component
@AllArgsConstructor
public class AuthenticationTokenFilter extends OncePerRequestFilter {
    private final TokenStoreCache tokenStoreCache;

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain chain) throws ServletException, IOException {
        String accessToken = TokenUtils.getAccessToken(request);
        // accessToken为空，表示未登录
        if (StringUtils.isBlank(accessToken)) {
            chain.doFilter(request, response);
            return;
        }

        // 获取登录用户信息
        UserDetail user = tokenStoreCache.getUser(accessToken);
        if (user == null) {
            chain.doFilter(request, response);
            return;
        }

        // 用户存在
        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

        // 新建 SecurityContext
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);

        chain.doFilter(request, response);
    }
}
