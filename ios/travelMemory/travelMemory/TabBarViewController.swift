//
//  TabBarViewController.swift
//  travelMemory
//
//  Created by 정현화 on 2023/07/31.
//

import UIKit

class TabBarViewController: UITabBarController {
    
    private lazy var recommendViewcontroller: UINavigationController = {
        let viewController = RecommendViewController()
        let tabBarItem = UITabBarItem(title: "추천", image: UIImage(named: "recommendViewButton"), tag: 0)
        tabBarItem.imageInsets = UIEdgeInsets(top: 40, left: 0, bottom: 40, right: 0)
        viewController.tabBarItem = tabBarItem
        let navigationView = UINavigationController(rootViewController: viewController)
        return navigationView
    }()
    
    private lazy var mainViewController: UINavigationController = {
        let viewController = MainViewController()
        let tabBarItem = UITabBarItem(title: "내 주변", image: UIImage(named: "mainViewButton"), tag: 1)
        tabBarItem.imageInsets = UIEdgeInsets(top: 40, left: 0, bottom: 40, right: 0)
        viewController.tabBarItem = tabBarItem
        let navigationView = UINavigationController(rootViewController: viewController)
        return navigationView
    }()
    
    private lazy var registerViewController: UINavigationController = {
        let viewController = RegisterViewController()
        let tabBarItem = UITabBarItem(title: "등록", image: UIImage(named: "registerViewButton"), tag: 2)
        tabBarItem.imageInsets = UIEdgeInsets(top: 20, left: 0, bottom: 20, right: 0)
        viewController.tabBarItem = tabBarItem
        let navigationView = UINavigationController(rootViewController: viewController)
        return navigationView
    }()
    
    private lazy var favoriteViewController: UINavigationController = {
        let viewController = FavoriteViewController()
        let tabBarItem = UITabBarItem(title: "찜", image: UIImage(named: "favoriteViewButton"), tag: 3)
        tabBarItem.imageInsets = UIEdgeInsets(top: 40, left: 0, bottom: 40, right: 0)
        viewController.tabBarItem = tabBarItem
        let navigationView = UINavigationController(rootViewController: viewController)
        return navigationView
    }()
   
    private lazy var myPageViewController: UINavigationController = {
        let viewController = MyPageViewController()
        let tabBarItem = UITabBarItem(title: "마이", image: UIImage(named: "myPageViewButton"), tag: 4)
        tabBarItem.imageInsets = UIEdgeInsets(top: 40, left: 0, bottom: 40, right: 0)
        viewController.tabBarItem = tabBarItem
        let navigationView = UINavigationController(rootViewController: viewController)
        return navigationView
    }()

    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.delegate = self
        
        self.view.backgroundColor = UIColor.gray
        viewControllers = [recommendViewcontroller, mainViewController, registerViewController, favoriteViewController, myPageViewController]
        self.selectedIndex = 1
        self.configureTabBar()
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        self.navigationItem.hidesBackButton = true
    }
    
    override func viewDidLayoutSubviews() {
        super.viewDidLayoutSubviews()
        var tabFrame = self.tabBar.frame
        tabFrame.size.height = 100
        tabFrame.origin.y = self.view.frame.size.height - 100
        self.tabBar.frame = tabFrame
    }
}

extension TabBarViewController {
    func configureTabBar() {
        self.tabBar.tintColor = .label
        self.tabBar.layer.cornerRadius = 20
        self.tabBar.layer.masksToBounds = true
        self.tabBar.layer.backgroundColor = UIColor.systemBackground.cgColor
        self.tabBar.layer.borderColor = UIColor.lightGray.cgColor
        self.tabBar.layer.borderWidth = 0.4
    }
}

extension TabBarViewController: UITabBarControllerDelegate {
    func tabBarController(_ tabBarController: UITabBarController, shouldSelect viewController: UIViewController) -> Bool {
        if viewController.tabBarItem.tag == 2 {
            print("등록 버튼 클릭")
            let modalViewController = RegisterViewController()
            modalViewController.modalPresentationStyle = .fullScreen
            let navigationView = UINavigationController(rootViewController: modalViewController)
            present(navigationView, animated: true)
            
            return false
        } else {
            return true
        }
    }
}
