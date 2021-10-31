// 数据库地址
function setDbAddress(dbAddress) {
    localStorage.setItem(KEY_DB_ADDRESS, dbAddress)
}

function getDbAddress() {
    return localStorage.getItem(KEY_DB_ADDRESS)
}

// 数据库用户名
function setDbUsername(dbUsername) {
    localStorage.setItem(KEY_DB_USERNAME, dbUsername)
}

function getDbUsername() {
    return localStorage.getItem(KEY_DB_USERNAME)
}

// 数据库密码
function setDbPassword(dbPassword) {
    localStorage.setItem(KEY_DB_PASSWORD, dbPassword)
}

function getDbPassword() {
    return localStorage.getItem(KEY_DB_PASSWORD)
}

// 作者
function setAuthor(author) {
    localStorage.setItem(KEY_AUTHOR, author)
}

function getAuthor() {
    return localStorage.getItem(KEY_AUTHOR)
}

function removeAuthor() {
    return localStorage.removeItem(KEY_AUTHOR)
}

// 输出目录
function setOutputDir(outputDir) {
    localStorage.setItem(KEY_OUTPUT_DIR, outputDir)
}

function getOutputDir() {
    return localStorage.getItem(KEY_OUTPUT_DIR)
}