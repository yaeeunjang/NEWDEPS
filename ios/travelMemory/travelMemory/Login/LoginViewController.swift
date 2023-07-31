//
//  LoginViewController.swift
//  travelMemory
//
//  Created by 정현화 on 2023/07/29.
//

import UIKit

class LoginViewController: UIViewController {
    
    var loginView: LoginView { return view as! LoginView }
    
    override func loadView() {
        view = LoginView()
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        loginView.naverButton.addTarget(self, action: #selector(naverButtonPressed(_:)), for: .touchUpInside)
        loginView.kakaoButton.addTarget(self, action: #selector(kakaoButtonPressed(_:)), for: .touchUpInside)
    }
    
    @objc func naverButtonPressed(_: UIButton) {
        let mainViewController = TabBarViewController()
        navigationController?.pushViewController(mainViewController, animated: true)
    }
    
    @objc func kakaoButtonPressed(_: UIButton) {
        let mainViewController = TabBarViewController()
        navigationController?.pushViewController(mainViewController, animated: true)
    }
}
