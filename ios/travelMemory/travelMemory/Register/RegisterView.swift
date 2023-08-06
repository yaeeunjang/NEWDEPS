//
//  RegisterView.swift
//  travelMemory
//
//  Created by 정현화 on 2023/08/05.
//

import UIKit

class RegisterView: UIView {
    
    public let titleLabel = UILabel()
    public let imageLabel = UILabel()
    public let imageView = UIImageView()
    public let dateLabel = UILabel()
    public let dateTextField = UITextField()
    public let placeLabel = UILabel()
    public let placeTextField = UITextField()
    public let contentLabel = UILabel()
    public let contentTextField = UITextField()
    public let publicYNLabel = UILabel()
    public let commentYNLable = UILabel()
    public let saveButton = UIButton()
    
    lazy var publicYNSwitch: UISwitch = {
        let switchControl = UISwitch()
        
        switchControl.onTintColor = UIColor(red: 130/255, green: 99/255, blue: 201/255, alpha: 1)
        switchControl.translatesAutoresizingMaskIntoConstraints = false
        
        return switchControl
    }()
    
    lazy var commentYNSwitch: UISwitch = {
        let switchControl = UISwitch()
        
        switchControl.onTintColor = UIColor(red: 130/255, green: 99/255, blue: 201/255, alpha: 1)
        switchControl.translatesAutoresizingMaskIntoConstraints = false
        
        return switchControl
    }()

    init() {
        super.init(frame: .zero)
        self.backgroundColor = UIColor.white
        
        setupView(element: titleLabel, top:30, left: 30)
        titleLabel.text = "내 주변 등록"
        titleLabel.font = .systemFont(ofSize: 20)
        titleLabel.translatesAutoresizingMaskIntoConstraints = false
        
        setupView(element: imageLabel, left: 30)
        imageLabel.text = "사진"
        imageLabel.font = .systemFont(ofSize: 16)
        imageLabel.translatesAutoresizingMaskIntoConstraints = false
        imageLabel.topAnchor.constraint(equalTo: titleLabel.bottomAnchor, constant: 30).isActive = true
        
        setupView(element: imageView, left: 30)
        imageView.layer.borderColor = UIColor.lightGray.cgColor
        imageView.layer.borderWidth = 1.0
        imageView.layer.cornerRadius = 10
        imageView.widthAnchor.constraint(equalToConstant: 100).isActive = true
        imageView.heightAnchor.constraint(equalToConstant: 100).isActive = true
        imageView.topAnchor.constraint(equalTo: imageLabel.bottomAnchor, constant: 15).isActive = true
        
        setupView(element: dateLabel, left: 30)
        dateLabel.text = "날짜"
        dateLabel.font = .systemFont(ofSize: 16)
        dateLabel.translatesAutoresizingMaskIntoConstraints = false
        dateLabel.topAnchor.constraint(equalTo: imageView.bottomAnchor, constant: 20).isActive = true
        
        setupView(element: dateTextField, right: -30, left: 30)
        dateTextField.layer.borderColor = UIColor.lightGray.cgColor
        dateTextField.layer.borderWidth = 1.0
        dateTextField.layer.cornerRadius = 10
        dateTextField.heightAnchor.constraint(equalToConstant: 50).isActive = true
        dateTextField.topAnchor.constraint(equalTo: dateLabel.bottomAnchor, constant: 10).isActive = true

        setupView(element: placeLabel, left: 30)
        placeLabel.text = "장소"
        placeLabel.font = .systemFont(ofSize: 16)
        placeLabel.translatesAutoresizingMaskIntoConstraints = false
        placeLabel.topAnchor.constraint(equalTo: dateTextField.bottomAnchor, constant: 20).isActive = true
        
        setupView(element: placeTextField, right: -30, left: 30)
        placeTextField.layer.borderColor = UIColor.lightGray.cgColor
        placeTextField.layer.borderWidth = 1.0
        placeTextField.layer.cornerRadius = 10
        placeTextField.heightAnchor.constraint(equalToConstant: 50).isActive = true
        placeTextField.topAnchor.constraint(equalTo: placeLabel.bottomAnchor, constant: 10).isActive = true

        setupView(element: contentLabel, left: 30)
        contentLabel.text = "내용"
        contentLabel.font = .systemFont(ofSize: 16)
        contentLabel.translatesAutoresizingMaskIntoConstraints = false
        contentLabel.topAnchor.constraint(equalTo: placeTextField.bottomAnchor, constant: 20).isActive = true
        
        setupView(element: contentTextField, right: -30, left: 30)
        contentTextField.layer.borderColor = UIColor.lightGray.cgColor
        contentTextField.layer.borderWidth = 1.0
        contentTextField.layer.cornerRadius = 10
        contentTextField.heightAnchor.constraint(equalToConstant: 100).isActive = true
        contentTextField.topAnchor.constraint(equalTo: contentLabel.bottomAnchor, constant: 10).isActive = true

        setupView(element: publicYNLabel, left: 30)
        publicYNLabel.text = "비공개"
        publicYNLabel.font = .systemFont(ofSize: 16)
        publicYNLabel.translatesAutoresizingMaskIntoConstraints = false
        publicYNLabel.topAnchor.constraint(equalTo: contentTextField.bottomAnchor, constant: 20).isActive = true
        
        setupView(element: publicYNSwitch, right: -30)
        publicYNSwitch.translatesAutoresizingMaskIntoConstraints = false
        publicYNSwitch.centerYAnchor.constraint(equalTo: publicYNLabel.centerYAnchor).isActive = true
        
        setupView(element: commentYNLable, left: 30)
        commentYNLable.text = "댓글 허용"
        commentYNLable.font = .systemFont(ofSize: 16)
        commentYNLable.translatesAutoresizingMaskIntoConstraints = false
        commentYNLable.topAnchor.constraint(equalTo: publicYNLabel.bottomAnchor, constant: 20).isActive = true
        
        setupView(element: commentYNSwitch, right: -30)
        commentYNSwitch.translatesAutoresizingMaskIntoConstraints = false
        commentYNSwitch.centerYAnchor.constraint(equalTo: commentYNLable.centerYAnchor).isActive = true
        
        setupView(element: saveButton, right: -30, left: 30)
        saveButton.setTitle("저장하기", for: .normal)
        saveButton.backgroundColor = UIColor(red: 130/255, green: 99/255, blue: 201/255, alpha: 1)
        saveButton.layer.cornerRadius = 10
        saveButton.translatesAutoresizingMaskIntoConstraints = false
        saveButton.heightAnchor.constraint(equalToConstant: 50).isActive = true
        saveButton.topAnchor.constraint(equalTo: commentYNSwitch.bottomAnchor, constant: 20).isActive = true
        
        }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
}
