package com.codegym.repository;

import com.codegym.model.MailSettings;

import java.util.List;

public interface IMailSettingRepository {
    List<MailSettings> getAll();
    void save(MailSettings mailSettings);
}
