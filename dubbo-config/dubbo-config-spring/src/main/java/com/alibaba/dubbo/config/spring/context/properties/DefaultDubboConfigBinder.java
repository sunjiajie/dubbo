/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.dubbo.config.spring.context.properties;

import com.alibaba.dubbo.config.AbstractConfig;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.validation.DataBinder;

import java.util.Map;

import static com.alibaba.dubbo.config.spring.util.PropertySourcesUtils.getSubProperties;

/**
 * Default {@link DubboConfigBinder} implementation based on Spring {@link DataBinder}
 *
 *
 * 当某个AbstractConfig类型的Bean，在经过DubboConfigBindingBeanPostProcessor处理时，此时Bean对象中的属性是没有值的，会利用DefaultDubboConfigBinder进行赋值。底层就是利用Spring中的DataBinder技术，结合properties文件对对应的属性进行赋值。
 *
 * 对应一个AbstractConfig类型（针对的其实是子类，比如ApplicationConfig、RegistryConfig）的Bean，每个类都有一些属性，而properties文件是一个key-value对，所以实际上DataBinder就是将属性名和properties文件中的key进行匹配，如果匹配成功，则把value赋值给属性
 */
public class DefaultDubboConfigBinder extends AbstractDubboConfigBinder {

    @Override
    public <C extends AbstractConfig> void bind(String prefix, C dubboConfig) {
        DataBinder dataBinder = new DataBinder(dubboConfig);
        // Set ignored*
        dataBinder.setIgnoreInvalidFields(isIgnoreInvalidFields());
        dataBinder.setIgnoreUnknownFields(isIgnoreUnknownFields());
        // Get properties under specified prefix from PropertySources
        // getPropertySources()会拿到由@PropertySource注入进来的properties文件中的内容
        // 同时还包括当前java的所有环境变量，包括手动通过-D添加的配置

        Map<String, Object> properties = getSubProperties(getPropertySources(), prefix);
        // Convert Map to MutablePropertyValues
        MutablePropertyValues propertyValues = new MutablePropertyValues(properties);
        // Bind
        dataBinder.bind(propertyValues);
    }

}
