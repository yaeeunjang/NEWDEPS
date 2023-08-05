//
//  RegisterViewController.swift
//  travelMemory
//
//  Created by 정현화 on 2023/08/05.
//

import UIKit

class RegisterViewController: UIViewController {
    
    var registerView: RegisterView { return view as! RegisterView }
    
    override func loadView() {
        view = RegisterView()
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
}
