package com.yakumobooks.scheduler.controller

import org.springframework.web.bind.annotation.{GetMapping, RestController}

@RestController
class IndexController {

    @GetMapping(value=Array("/index"))
    def index():String={
        return "helm is  spring dependency package"
    }
}
