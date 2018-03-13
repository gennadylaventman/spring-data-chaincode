/*
 *
 *  Copyright 2017 IBM - All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.springframework.data.chaincode.repository.wiring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.chaincode.events.FabricEventsConfig;
import org.springframework.data.chaincode.repository.config.EnableChaincodeRepositories;
import org.springframework.data.chaincode.sdk.client.ChaincodeClient;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan
@Import({FabricEventsConfig.class})
@EnableChaincodeRepositories(basePackages = {"org.springframework.data.chaincode.repository.wiring"})
public class TestConfig {

    public class TestChaincodeClient implements ChaincodeClient {

        public List<String> ccReg = new ArrayList<>();
        public List<String> chReg = new ArrayList<>();


        @Override
        public String invokeQuery(String chName, String ccName, String ccVer, String func, String[] args) {
            return "queried";
        }


        @Override
        public String invokeChaincode(String chName, String ccName, String ccVer, String func, String[] args) {
            return "invoked";
        }

        @Override
        public void startChaincodeEventsListener(String chName, String ccName) {
            if (!ccReg.contains(ccName))
                ccReg.add(ccName);

        }

        @Override
        public void startBlockEventsListener(String chName) {
            if (!chReg.contains(chName))
                chReg.add(chName);
        }
    }

    @Bean
    public ChaincodeClient chaincodeClient() {
        return new TestChaincodeClient();
    }

}
