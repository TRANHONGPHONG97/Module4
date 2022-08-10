package com.codegym.repository.imlp;

import com.codegym.model.MailSettings;
import com.codegym.repository.IMailSettingRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailSettingRepository implements IMailSettingRepository {
    static List<MailSettings> mailSettingsList = new ArrayList<>();
    static {
        mailSettingsList.add(new MailSettings("English","10",true,"Thunder Storm"));
        mailSettingsList.add(new MailSettings("Vietnamese","50",false,"Thunder Lightning"));
    }


    @Override
    public List<MailSettings> getAll() {
        return mailSettingsList;
    }

    @Override
    public void save(MailSettings mailSettings) {
        mailSettingsList.add(mailSettings);
    }
}


