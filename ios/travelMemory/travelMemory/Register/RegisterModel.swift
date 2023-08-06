//
//  RegisterModel.swift
//  travelMemory
//
//  Created by 정현화 on 2023/08/05.
//

import Foundation

struct Post {
    
    var userId: String
    var content: String
    var viewCount: Int
    var placeName: String
    var dateTime: Date
    var latitude: Double
    var longitude: Double
    var insertYMD: Date
    var modYMD: Date
    
    init(userId: String, content: String, viewCount: Int, placeName: String, dateTime: Date, latitude: Double, longitude: Double, insertYMD: Date, modYMD: Date) {
        self.userId = userId
        self.content = content
        self.viewCount = viewCount
        self.placeName = placeName
        self.dateTime = dateTime
        self.latitude = latitude
        self.longitude = longitude
        self.insertYMD = insertYMD
        self.modYMD = modYMD
    }
}
