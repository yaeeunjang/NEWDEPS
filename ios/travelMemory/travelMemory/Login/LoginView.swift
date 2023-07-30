//
//  LoginView.swift
//  travelMemory
//
//  Created by 정현화 on 2023/07/29.
//

import UIKit

class LoginView: UIView {
    
    public let logoImage = UIImageView(image: UIImage(named: "appLogo"))
    public let naverButton = NaverButton()
    public let kakaoButton = KakaoButton()
    
    init() {
        super.init(frame: .zero)
        self.backgroundColor = UIColor.white
        
        setupView(element: logoImage, top: 300, centerX: 0)
        logoImage.widthAnchor.constraint(equalToConstant: 150).isActive = true
        logoImage.heightAnchor.constraint(equalToConstant: 150).isActive = true
        
        setupView(element: naverButton, left: 50)
        naverButton.topAnchor.constraint(equalTo: logoImage.bottomAnchor, constant: 75).isActive = true
        
        setupView(element: kakaoButton)
        kakaoButton.leftAnchor.constraint(equalTo: naverButton.rightAnchor, constant: 25).isActive = true
        kakaoButton.topAnchor.constraint(equalTo: logoImage.bottomAnchor, constant: 75).isActive = true
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
}

class NaverButton: UIButton {
    
    init(){
        super.init(frame: .zero)
        setBackgroundImage(UIImage(named: "naverButton"), for: .normal)
        
        widthAnchor.constraint(equalToConstant: 50).isActive = true
        heightAnchor.constraint(equalToConstant: 50).isActive = true
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
}

class KakaoButton: UIButton {
    
    init(){
        super.init(frame: .zero)
        setBackgroundImage(UIImage(named: "kakaoButton"), for: .normal)
        
        widthAnchor.constraint(equalToConstant: 50).isActive = true
        heightAnchor.constraint(equalToConstant: 50).isActive = true
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
}
