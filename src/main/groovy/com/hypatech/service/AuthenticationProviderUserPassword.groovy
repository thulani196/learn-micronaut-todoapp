package com.hypatech.service

import groovy.transform.CompileStatic
import io.micronaut.security.authentication.AuthenticationFailed
import io.micronaut.security.authentication.AuthenticationProvider
import io.micronaut.security.authentication.AuthenticationRequest
import io.micronaut.security.authentication.AuthenticationResponse
import io.micronaut.security.authentication.UserDetails
import io.reactivex.Flowable
import org.reactivestreams.Publisher

import javax.inject.Singleton


@CompileStatic
@Singleton
class AuthenticationProviderUserPassword implements AuthenticationProvider {
    /**
     * Authenticates a user with the given request. If a successful authentication is
     * returned, the object must be an instance of {@link UserDetails}.
     *
     * @param authenticationRequest The request to authenticate
     * @return A publisher that emits 0 or 1 responses
     */
    @Override
    Publisher<AuthenticationResponse> authenticate(AuthenticationRequest authenticationRequest) {
        if (authenticationRequest.identity == "sherlock" &&
                authenticationRequest.secret == "password") {
            UserDetails userDetails = new UserDetails((String) authenticationRequest.identity, [])
            return Flowable.just(userDetails) as Publisher<AuthenticationResponse>
        }
        Flowable.just(new AuthenticationFailed()) as Publisher<AuthenticationResponse>
    }
}
