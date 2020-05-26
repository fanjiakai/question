package com.question.oauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/30 10:23
 */
@Component
public class SheepUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        /*if( !"codesheep".equals(s) )
            throw new UsernameNotFoundException("用户" + s + "不存在" );
            "{bcrypt}" +passwordEncoder.encode("123456")
*/
        return new User( s, "{bcrypt}" + new BCryptPasswordEncoder().encode("123456"), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_NORMAL,ROLE_MEDIUM,ROLE_aaa,ROLE_bbb"));
    }
}
