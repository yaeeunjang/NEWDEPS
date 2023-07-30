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
    }
}
