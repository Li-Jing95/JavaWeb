//获取对应控件
var totalPage = document.getElementById("spanTotalPage");//总页数
var pageNum = document.getElementById("spanPageNum");//当前页
var totalInfor = document.getElementById("spanTotalInfor");//记录总数
var pageNum2 = document.getElementById("Text1");//当前页文本框

var spanPre = document.getElementById("spanPre");//上一页
var spanNext = document.getElementById("spanNext");//下一页
var spanFirst = document.getElementById("spanFirst");//首页
var spanLast = document.getElementById("spanLast");//尾页
var pageSize = 5;//每页信息条数

var numberRowsInTable = theTable.rows.length - 1;//表格最大行数

var page = 1;

//下一页
function next() {
    if (pageCount() <= 1) {
    }
    else {
        hideTable();
        currentRow = pageSize * page + 1; //下一页的第一行
        maxRow = currentRow + pageSize;    //下一页的一行
        if (maxRow > numberRowsInTable) maxRow = numberRowsInTable + 1;//如果计算中下一页最后一行大于实际最后一行行号
        for (var i = currentRow; i < maxRow; i++) {
            theTable.rows[i].style.display = '';
        }
        page++;
        pageNum2.value = page;
        if (maxRow == numberRowsInTable) { //如果下一页的最后一行是表格的最后一行
            nextNoLink(); //下一页 和尾页 不点击
            lastNoLink();
        }
        showPage();//更新page显示
        if (page == pageCount()) {//如果当前页是尾页
            nextNoLink();
            lastNoLink();
        }

        preLink();
        firstLink();
    }
}


//上一页
function pre() {
    if (pageCount() <= 1) {
    }
    else {
        hideTable();
        page--;
        pageNum2.value = page;
        currentRow = pageSize * page + 1;//下一页的第一行
        maxRow = currentRow - pageSize;//本页的第一行
        if (currentRow > numberRowsInTable) currentRow = numberRowsInTable;//如果计算中本页的第一行小于实际首页的第一行行号，则更正
        for (var i = maxRow; i < currentRow; i++) {
            theTable.rows[i].style.display = '';
        }
        if (maxRow == 0) {
            preNoLink();
            firstNoLink();
        }
        showPage();//更新page显示
        if (page == 1) {
            firstNoLink();
            preNoLink();
        }
        nextLink();
        lastLink();
    }
}


//第一页
function first() {

    if (pageCount() <= 1) {
    }
    else {
        hideTable();//隐藏所有行
        page = 1;
        pageNum2.value = page;
        for (var i = 1; i < pageSize + 1; i++) {//显示第一页的信息
            theTable.rows[i].style.display = '';
        }
        showPage();//设置当前页

        firstNoLink();
        preNoLink();
        nextLink();
        lastLink();
    }
}


//最后一页
function last() {
    if (pageCount() <= 1) {
    }
    else {
        hideTable();//隐藏所有行
        page = pageCount();//将当前页设置为最大页数
        pageNum2.value = page;
        currentRow = pageSize * (page - 1) + 1;//获取最后一页的第一行行号
        for (var i = currentRow; i < numberRowsInTable + 1; i++) {//显示表格中最后一页信息
            theTable.rows[i].style.display = '';
        }

        showPage();
        lastNoLink();
        nextNoLink();
        preLink();
        firstLink();
    }
}


function hideTable() {//隐藏表格内容
    for (var i = 0; i < numberRowsInTable + 1; i++) {
        theTable.rows[i].style.display = 'none';
    }
    theTable.rows[0].style.display = '';//标题栏显示
}


function showPage() {//设置当前页数
    pageNum.innerHTML = page;
}

function inforCount() {//设置总记录数
    spanTotalInfor.innerHTML = numberRowsInTable;
}

//总共页数
function pageCount() {
    var count = 0;
    if (numberRowsInTable % pageSize != 0) count = 1;
    return parseInt(numberRowsInTable / pageSize) + count;
}


//显示链接 link方法将相应的文字变成可点击翻页的  nolink方法将对应的文字变成不可点击的
function preLink() {
    spanPre.innerHTML = "<a href='javascript:pre();'>上一页</a>";
}

function preNoLink() {
    spanPre.innerHTML = "上一页";
}

function nextLink() {
    spanNext.innerHTML = "<a href='javascript:next();'>下一页</a>";
}

function nextNoLink() {
    spanNext.innerHTML = "下一页";
}

function firstLink() {
    spanFirst.innerHTML = "<a href='javascript:first();'>首页</a>";
}

function firstNoLink() {
    spanFirst.innerHTML = "首页";
}

function lastLink() {
    spanLast.innerHTML = "<a href='javascript:last();'>尾页</a>";
}

function lastNoLink() {
    spanLast.innerHTML = "尾页";
}

//初始化表格
function hide() {
    for (var i = pageSize + 1; i < numberRowsInTable + 1; i++) {
        theTable.rows[i].style.display = 'none';
    }
    theTable.rows[0].style.display = '';

    inforCount();

    totalPage.innerHTML = pageCount();
    showPage();
    pageNum2.value = page;

    if (pageCount() > 1) {
        nextLink();
        lastLink();
    }

}

hide();