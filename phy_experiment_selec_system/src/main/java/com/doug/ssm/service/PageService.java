package com.doug.ssm.service;

import com.doug.ssm.entity.InfoPage;

import java.util.List;

public interface PageService {
    InfoPage subList(int page, List list);
}
