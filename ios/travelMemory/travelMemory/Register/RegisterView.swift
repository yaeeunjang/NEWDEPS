//
//  RegisterView.swift
//  travelMemory
//
//  Created by 정현화 on 2023/08/05.
//

import UIKit

class RegisterView: UIView {
    
    public let textLable = UILabel()

    init() {
        super.init(frame: .zero)
        self.backgroundColor = UIColor.white

        setupView(element: textLable)
        textLable.text = "내 주변 등록 화면"
        textLable.textAlignment = .center
        textLable.font = .systemFont(ofSize: 20)
        textLable.translatesAutoresizingMaskIntoConstraints = false
        
        
        textLable.centerXAnchor.constraint(equalTo: self.centerXAnchor).isActive = true
        textLable.centerYAnchor.constraint(equalTo: self.centerYAnchor).isActive = true
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
}
