package com.cg.service;

import com.cg.dao.MemberDAO;
import com.cg.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author TVD
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDAO memberDAO;

    @Override
    public Member login(String uname, String passwd) {
        return memberDAO.login(uname, passwd);
    }

}
