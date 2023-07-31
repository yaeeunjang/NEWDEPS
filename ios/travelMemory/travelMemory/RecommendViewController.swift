//
//  RecommendViewController.swift
//  travelMemory
//
//  Created by 정현화 on 2023/07/31.
//

import UIKit

class RecommendViewController: UIViewController {
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let textLable = UILabel()
        textLable.text = "추천 화면"
        textLable.textAlignment = .center
        textLable.font = .systemFont(ofSize: 20)
        textLable.translatesAutoresizingMaskIntoConstraints = false
        
        self.view.backgroundColor = UIColor.lightGray
        self.view.addSubview(textLable)
        
        textLable.centerXAnchor.constraint(equalTo: view.centerXAnchor).isActive = true
        textLable.centerYAnchor.constraint(equalTo: view.centerYAnchor).isActive = true
    }
}
