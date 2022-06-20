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

// 列表-数据库
function setListDb(list) {
    let val = JSON.stringify(list)
    localStorage.setItem(KEY_LIST_DB, val)
}

function getListDb() {
    let val = localStorage.getItem(KEY_LIST_DB)
    return JSON.parse(val)
}

function removeListDb() {
    return localStorage.removeItem(KEY_LIST_DB)
}

// 数据配置
function setDataConfig(obj) {
    let val = JSON.stringify(obj)
    localStorage.setItem(KEY_DATA_CONFIG, val)
}

function getDataConfig() {
    let val = localStorage.getItem(KEY_DATA_CONFIG)
    return JSON.parse(val)
}

function removeDataConfig() {
    return localStorage.removeItem(KEY_DATA_CONFIG)
}