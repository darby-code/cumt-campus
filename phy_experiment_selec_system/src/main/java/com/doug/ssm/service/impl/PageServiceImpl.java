package com.doug.ssm.service.impl;

import com.doug.ssm.entity.InfoPage;
import com.doug.ssm.service.PageService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl implements PageService {

    @Override
    public InfoPage subList(int page, List list) {
        InfoPage infoPage = new InfoPage();
        infoPage.setCurrentPage(page);
        int count = list.size();
        infoPage.setRecordSize(6);
        infoPage.setTotalPage(count % 6 == 0 ? count / 6 : count / 6 + 1);
        infoPage.setStart((infoPage.getCurrentPage() - 1) * infoPage.getRecordSize());
        infoPage.setDataPerPage(list.subList(infoPage.getStart()
                , count - infoPage.getStart() > infoPage.getRecordSize()
                        ? infoPage.getStart() + infoPage.getRecordSize() : count));
        return infoPage;
    }
}
