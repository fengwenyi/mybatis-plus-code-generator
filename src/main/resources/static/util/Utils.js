/**
 * 字符串判空
 * @param x
 * @returns {boolean}
 */
function isEmpty(x) {
    return x === null
        || x === undefined
        || x.trim() === ''
        || x.trim() === 'null'
        || x.trim() === 'undefined';
}

/**
 * 字符串判非空
 * @param x
 * @returns {boolean}
 */
function isNotEmpty(x) {
    return !isEmpty(x);
}

/**
 * 对象判空
 * @param x
 * @returns {boolean}
 */
function isNull(x) {
    return x === null
        || x === undefined;
}

/**
 * 对象判非空
 * @param x
 * @returns {boolean}
 */
function nonNull(x) {
    return !isNull(x)
}

/**
 * 随机颜色
 * @returns {string}
 */
function randomColor(){
    let colorAngle = Math.floor(Math.random()*360);
    return 'hsla('+ colorAngle +',100%,50%,1)';
}

function guid() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        let r = Math.random()*16|0, v = c == 'x' ? r : (r&0x3|0x8);
        return v.toString(16);
    });
}