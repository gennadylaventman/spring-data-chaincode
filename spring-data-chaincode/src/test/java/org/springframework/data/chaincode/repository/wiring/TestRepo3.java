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

import org.springframework.data.chaincode.repository.ChaincodeInvoke;
import org.springframework.data.chaincode.repository.ChaincodeQuery;
import org.springframework.data.chaincode.repository.ChaincodeRepository;

public interface TestRepo3 extends ChaincodeRepository {
    @ChaincodeInvoke
    String invokeMethod(String arg1);

    @ChaincodeQuery
    String qMethod(String arg);
}
