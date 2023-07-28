//
//  LoginModel.swift
//  travelMemory
//
//  Created by 정현화 on 2023/07/29.
//

import Foundation

struct User {
    
    var loginId: String
    var nickname: String
    var insertYMD: Date
    var modYMD: Date
    
    init(loginId: String, nickname: String, insertYMD: Date, modYMD: Date) {
        self.loginId = loginId
        self.nickname = nickname
        self.insertYMD = insertYMD
        self.modYMD = modYMD
    }
}
