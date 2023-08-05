//
//  RegisterViewController.swift
//  travelMemory
//
//  Created by 정현화 on 2023/08/05.
//

import UIKit

class RegisterViewController: UIViewController {
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let textLable = UILabel()
        textLable.text = "등록 화면"
        textLable.textAlignment = .center
        textLable.font = .systemFont(ofSize: 20)
        textLable.translatesAutoresizingMaskIntoConstraints = false
        
        self.view.backgroundColor = UIColor.lightGray
        self.view.addSubview(textLable)
        
        textLable.centerXAnchor.constraint(equalTo: view.centerXAnchor).isActive = true
        textLable.centerYAnchor.constraint(equalTo: view.centerYAnchor).isActive = true
    }
}
