<template>
    <div>
        <el-menu
            :default-active="$route.path"
            router
            mode="horizontal"
            background-color="#639EA0"
            text-color="#BFCBD9"
            active-text-color="#409EFF">
            <el-menu-item index="/index" style="margin-left= 50px ;color:white;font-size: 20px;font-weight:bold">欢迎</el-menu-item>
            <!-- 退出 -->
            <div class="right">
                <!-- 更多 -->
                <el-dropdown>
                    <span class="el-dropdown-link" style="color:white">
                    欢迎您回来<i class="el-icon-arrow-down el-icon--right"></i>
                    </span>
                    <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item>个人信息</el-dropdown-item>
                    <el-dropdown-item divided>退出</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
            </div>
        </el-menu>
    </div>
</template>

<script>

    export default {
        name: "Header",
        methods: {
            
        },
    }
</script>

<style scoped>
    .logout {
        color: #BFCBD9;
        font-size: 32px;
        float: right;
        padding: 15px 30px;
        cursor: pointer;
    }

    .right{
        float: right;
        padding: 15px 30px;
    }
</style>