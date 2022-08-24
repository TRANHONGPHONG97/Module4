package com.cg.service;

import com.cg.model.Member;

/**
 *
 * @author TVD
 */
public interface MemberService {

    // login
    public Member login(String uname, String passwd);

}
