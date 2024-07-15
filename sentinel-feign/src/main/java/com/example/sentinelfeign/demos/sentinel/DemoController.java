/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.sentinelfeign.demos.sentinel;

import com.example.sentinelfeign.service.feign.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Eric Zhao
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    @Resource
    FooService fooService;
    @Autowired
    private DemoService demoService;

    @GetMapping("/hello")
    public String apiSayHello(@RequestParam String name) {
        return fooService.getCache();
    }

    @GetMapping("/bonjour/{name}")
    public String apiSayHelloLocal(@PathVariable String name) {
        return demoService.bonjour(name);
    }
}
