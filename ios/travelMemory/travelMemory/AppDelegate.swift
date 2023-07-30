//
//  AppDelegate.swift
//  travelMemory
//
//  Created by 정현화 on 2023/07/29.
//

import UIKit
import NaverThirdPartyLogin

@main
class AppDelegate: UIResponder, UIApplicationDelegate {



    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        // Override point for customization after application launch.
        
        // 네이버 로그인 설정
        naverLogin()
        
        return true
    }

    // MARK: UISceneSession Lifecycle

    func application(_ application: UIApplication, configurationForConnecting connectingSceneSession: UISceneSession, options: UIScene.ConnectionOptions) -> UISceneConfiguration {
        // Called when a new scene session is being created.
        // Use this method to select a configuration to create the new scene with.
        return UISceneConfiguration(name: "Default Configuration", sessionRole: connectingSceneSession.role)
    }

    func application(_ application: UIApplication, didDiscardSceneSessions sceneSessions: Set<UISceneSession>) {
        // Called when the user discards a scene session.
        // If any sessions were discarded while the application was not running, this will be called shortly after application:didFinishLaunchingWithOptions.
        // Use this method to release any resources that were specific to the discarded scenes, as they will not return.
    }


    // 네이버 로그인
    func naverLogin () {
        let instance = NaverThirdPartyLoginConnection.getSharedInstance()
        
        // 둘 다 활성화 해두면 다운로드 된 앱 있는지 체크 후 있으면 네이버 앱, 없으면 사파리로 인증
        //instance?.isNaverAppOauthEnable = true // 네이버 앱으로 인증하는 방식 활성화
        instance?.isInAppOauthEnable = true // Safari에서 인증하는 방식 활성화
        
        instance?.serviceUrlScheme = "com.newdeps.travelMemory"
        instance?.consumerKey = "dCtqaYMuJNj82G55KOb0"
        instance?.consumerSecret = "_I9f3WSVyC"
        instance?.appName = "네이버 아이디로 로그인"
    }
    
}

