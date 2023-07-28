//
//  LoginView.swift
//  travelMemory
//
//  Created by 정현화 on 2023/07/29.
//

import UIKit

class LoginView: UIView {
    
    public let logoImage = UIImageView(image: UIImage(named: "appLogo"))
    
    init() {
        super.init(frame: .zero)
        self.backgroundColor = UIColor.white
        
        setupView(element: logoImage, top: 300, centerX: 0)
        logoImage.widthAnchor.constraint(equalToConstant: 150).isActive = true
        logoImage.heightAnchor.constraint(equalToConstant: 150).isActive = true
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
}
