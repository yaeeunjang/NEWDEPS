//
//  UIKit+setupView.swift
//  travelMemory
//
//  Created by 정현화 on 2023/07/29.
//

import UIKit

extension UIView {
    func setupView(element: UIView,
                   top: CGFloat? = nil,
                   right: CGFloat? = nil,
                   bottom: CGFloat? = nil,
                   left: CGFloat? = nil,
                   centerX: CGFloat? = nil,
                   centerY: CGFloat? = nil) {

        element.translatesAutoresizingMaskIntoConstraints = false
        self.addSubview(element)

        if let topConstant = top {
            element.topAnchor.constraint(equalTo: self.topAnchor, constant: topConstant).isActive = true
        }

        if let rightConstant = right {
            element.rightAnchor.constraint(equalTo: self.rightAnchor, constant: rightConstant).isActive = true
        }

        if let bottomConstant = bottom {
            element.bottomAnchor.constraint(equalTo: self.bottomAnchor, constant: bottomConstant).isActive = true
        }

        if let leftConstant = left {
            element.leftAnchor.constraint(equalTo: self.leftAnchor, constant: leftConstant).isActive = true
        }

        if let centerXConstant = centerX {
            element.centerXAnchor.constraint(equalTo: self.centerXAnchor, constant: centerXConstant).isActive = true
        }

        if let centerYConstant = centerY {
            element.centerYAnchor.constraint(equalTo: self.centerYAnchor, constant: centerYConstant).isActive = true
        }
    }
}
