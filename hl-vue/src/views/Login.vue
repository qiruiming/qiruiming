<template>
    <el-card class="login-card">
        <el-form ref="loginForm" 
        :model="loginForm" 
        :rules="loginFormRules"
        label-width="80px">
            <el-form-item label="用户名" prop="username">
                <el-input v-model="loginForm.username" placeholder="请输入用户名"></el-input>
            </el-form-item>
            <el-form-item label="密 码" prop="password">
                <el-input v-model="loginForm.password" placeholder="请输入密码"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="login">登 录</el-button>
                <el-button type="info" @click="resetLoginForm">取 消</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
import { login } from '@/api/login';
    export default {
        name: "Login",
        data() {
            return {
                loginForm:{    
                    username: '',
                    password: ''  
                },
                loginFormRules: {
                    username: [{ required:true, message: '请输入用户名码'}],
                    password: [{ required:true, message: '请输入密码'}],
                },
            }
        },

        methods: {

            /* 登录接口 */
            async login() {
                this.$refs.loginForm.validate(async v => {
                    if (v) {
                        const { code,message,data: token } = await login(this.loginForm)
                        if (code === 200 ) {
                            this.$message.success('登录成功!')
                            sessionStorage.setItem('token', token)
                            this.$router.push('/')
                        } else {
                            this.$message.error(message)
                        }
                        this.resetLoginForm()
                    } else {
                        return false
                    }
                })
            },

            /* 重置登录表单 */
            resetLoginForm() {
                this.$refs.loginForm.resetFields()
            },
        },
    }
</script>

<style scoped>

.login-card {
    width: 420px;
    height: 270px;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%,-50%);
}
</style>