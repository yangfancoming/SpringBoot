# IDEA 创建文件后 是否添加到 git  配置：version control --- confirmation ---- Add silently 创建文件自动add 到暂存区

# git 中 文件的三种状态 
    1.已修改 (文件呈蓝色)
    2.已暂存 (文件呈绿色)   
    3.已提交 (文件呈无色)

    git init   初始化 版本库 Initialized empty Git repository in E:/Git/mygit/.git/
    touch text.txt 新建文件  并 创建默认master分支 
    git add text.txt   将文件添加到 暂存区
    git rm --cached text.txt  将从暂存区中 删除   对应 IDEA revert 功能
    
    解决问题： 当使用 .gitignore 时候 发现某文件 已经在暂存区(文件呈绿色) 在提交时候 还是会出现在 提交框中 这时就需要使用 git rm --cached 命令
    将该文件从 暂存区中删除 后   再次提交就不会出现在 提交框中了 
    
# 设置 git 用户名和 email 
    1.全局方式  优先级低  ~/.gitconfig  很常用
    git config --global user.name 'goat'
    git config --global user.email '642744551@qq.com'
    
    2.局部方式  优先级高  .git/config  针对于特定的项目 
    git config --local user.name 'goat'
    git config --local user.email '642744551@qq.com'

    查看 用户名和email   
    git config user.name
    git config user.email
    
    