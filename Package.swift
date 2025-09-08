// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "RingtonePicker",
    platforms: [.iOS(.v14)],
    products: [
        .library(
            name: "RingtonePicker",
            targets: ["RingtonePickerPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", from: "7.0.0")
    ],
    targets: [
        .target(
            name: "RingtonePickerPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/RingtonePickerPlugin"),
        .testTarget(
            name: "RingtonePickerPluginTests",
            dependencies: ["RingtonePickerPlugin"],
            path: "ios/Tests/RingtonePickerPluginTests")
    ]
)