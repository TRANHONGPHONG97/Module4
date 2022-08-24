package com.cg.dao;

import com.cg.model.Member;

/**
 *
 * @author TVD
 */
public interface MemberDAO {

    // login
    public Member login(String uname, String passwd);

}
