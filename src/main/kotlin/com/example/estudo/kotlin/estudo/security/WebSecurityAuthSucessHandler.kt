package com.example.estudo.kotlin.estudo.security


import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler
import org.springframework.security.web.savedrequest.HttpSessionRequestCache
import org.springframework.util.StringUtils
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class WebSecurityAuthSucessHandler: SimpleUrlAuthenticationSuccessHandler() {

    var requestCache = HttpSessionRequestCache()

    override fun onAuthenticationSuccess(request: HttpServletRequest, response: HttpServletResponse, authentication: Authentication) {
        val savedRequest = requestCache.getRequest(request,response)
        if(savedRequest == null){
            clearAuthenticationAttributes(request)
            return
        }

        val parameter = request.getParameter(targetUrlParameter)
        val ok = isAlwaysUseDefaultTargetUrl|| targetUrlParameter != null && StringUtils.hasText(parameter)

        if(ok){
            requestCache.removeRequest(request,response)
            clearAuthenticationAttributes(request)
            return
        }
        clearAuthenticationAttributes(request)
    }

}