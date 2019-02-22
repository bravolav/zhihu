package com.themocker.zhihu.service;

import org.springframework.stereotype.Service;

@Service
public class WendaService {
    public String getMessage(int useId){
        return "hello message"+String.valueOf(useId);
    }
}
