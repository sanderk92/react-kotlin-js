;(function (config) {
    config.devServer = config.devServer || {}
    config.devServer.port = 8888
    config.devServer.hot = true
    config.devServer.proxy = {
        '/api': {
            target: 'http://localhost:8080',
            secure: false,
        }
    }

    // Increases continuous build speed
    config.devtool = 'cheap-source-map'

    // Default hint threshold is too low when using react
    config.performance = {
        maxEntrypointSize: 2048000,
        maxAssetSize: 2048000
    }

    // Required for external dependencies
    config.module.rules = [
        {
            test: /\.css$/i,
            use: ["style-loader", "css-loader"],
        }
    ]

    // Include resources in the build so we can import them in Kotlin
    config.resolve.modules.push("./src/main/resources")

    // This is to fix a quirk in Hot Module Replacement in Gradle + Webpack.
    config.watchOptions = {
        ignored: new RegExp("/build/processedResources/.*"),
    }

})(config);
