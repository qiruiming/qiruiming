<template>
    <div>
        <!-- 标题 -->
        <div style="text-align:left;">
            <span class="text">职工列表</span>
            <el-divider></el-divider>
        </div>
        <!-- 查询表单 -->
        <el-form ref="queryForm" :model="queryForm" inline size="mini" label-width="80px" >
            <div style="text-align:left;">
                <!-- 姓名 -->
                <el-form-item label="姓名" prop="partition">
                    <el-input v-model="queryForm.empName" placeholder="姓名" @keyup.enter.native="search"></el-input>
                </el-form-item>
                <!-- 部门 -->
                <el-form-item style="width:100px">
                    <el-select v-model="queryForm.deptName" placeholder="部门" clearable="true">
                        <el-option
                        v-for="item in options"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                        </el-option>
                    </el-select>
                </el-form-item>
                <!-- 学历 -->
                <el-form-item style="width:100px"> 
                    <el-select v-model="queryForm.empDegreeName" placeholder="学历" clearable="true">
                        <el-option
                        v-for="item in options2"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                        </el-option>
                    </el-select>
                </el-form-item>    
                <el-form-item>
                    <el-button type="primary"  @click="search" >查询</el-button>
                    <el-button type="primary" icon="el-icon-plus" plain size="mini" @click="handleAdd">添加</el-button>
                </el-form-item>
            </div>
        </el-form>

        
        <!-- 添加和修改的对话框 -->
        <el-dialog :title="title" :visible.sync="dialogVisible" :close-on-click-modal="false" width="500px">
            <el-form :model="inForm" ref="inForm" size="mini" label-width="80px" >
                <!-- 名字 -->
                <el-form-item label="职工姓名" prop="empName" style="width:300px">
                    <el-input v-model="inForm.empName" placeholder="请输入分区名字" ></el-input>
                </el-form-item>

                <el-form-item label="性别" prop="sex" style="width:300px">
                    <el-radio v-model="inForm.sex" label="男">男</el-radio>
                    <el-radio v-model="inForm.sex" label="女">女</el-radio>
                </el-form-item>

                <!-- 名字 -->
                <el-form-item label="年龄" prop="age" style="width:300px">
                    <el-input v-model="inForm.age" placeholder="请输入分区名字"></el-input>
                </el-form-item>

                <!-- 名字 -->
                <el-form-item label="部门名称" prop="deptName" style="width:300px">
                    <el-select v-model="inForm.deptName" placeholder="部门">
                        <el-option
                        v-for="item in options"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="学历" prop="empDegreeName" style="width:300px">
                    <el-select v-model="inForm.empDegreeName" placeholder="学历">
                        <el-option
                        v-for="item in options2"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                        </el-option>
                    </el-select>
                </el-form-item>
            </el-form>
            <div slot="footer">
                <el-button @click="carFormDialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="submit">确 定</el-button>
            </div>
        </el-dialog>
        
        <!-- 表格 -->
        <el-table :data="tartitionList" border stripe style="width: 100%; margin: 10px 0px">
            <!-- <el-table-column type="index" :index="calcIndex" ></el-table-column> -->
            <el-table-column label="序号" prop="id" width="60px"></el-table-column>
            <el-table-column label="职工姓名" prop="empName" width="150px"></el-table-column>
            <el-table-column label="性别" prop="sex"  width= "150px" ></el-table-column>
            <el-table-column label="年龄" prop="age"  width= "150px" ></el-table-column>
            <el-table-column label="部门名称" prop="deptName"  width= "150px" ></el-table-column>
            <el-table-column label="学历" prop="empDegreeName"  width= "150px" ></el-table-column>
            <el-table-column  label="操作" width="300px">
                <template  slot-scope="{ row }">
                    <el-button size="mini" @click="handleEdit(row)">编辑</el-button>
                    <el-button size="mini"  type="danger" @click="deleteUser(row.id)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <!-- 分页条 -->
        <el-pagination background layout="total, prev, pager, next, sizes, jumper" 
        :current-page="pageNumber" :page-size="pageSize" :page-sizes="[2,3,4,5,,10,20,30,50,100]" 
        @current-change="pageNumberChange" @size-change="pageSizeChange"
        :total="total">
        </el-pagination>
    </div>
</template>

<script>
import { addUser,getList,updateUser,deleteUser } from '@/api/user'

    export default {
        name: "index",
        data() {
            return {
                inForm:{
                    id:null,
                    empName:null,
                    sex:null,
                    age:null,
                    deptName:null,
                    empDegreeName:null
                },
                options: [{
                    value: '业务部',
                    label: '业务部'
                    }, {
                    value: '后勤部',
                    label: '后勤部'
                    }, {
                    value: '人事部',
                    label: '人事部'
                    }],
                options2: [{
                    value: '大专',
                    label: '大专'
                    }, {
                    value: '本科',
                    label: '本科'
                    }, {
                    value: '研究生',
                    label: '研究生'
                    }],
                pageNumber:1, // 页码
                pageSize:5,   // 每页显示记录数
                total:0,      // 总记录数
                tartitionList:[],
                queryForm: {  // 查询表单参数
                    id:'',
                    empName:'',
                    sex:'',
                    age:'',
                    deptName:'',
                    empDegreeName:''
                },
                fileList:[],
                title: '添加', 
                dialogVisible: false, // 控制添加或修改表单的展示
                disableEdit: true, //控制修改按钮是否可用
                disableDelete: true, //控制删除按钮是否可用
            }
        },

        methods: {
            /* 点击添加是触发 */
            handleAdd() {
                this.title = '添加'
                
                this.dialogVisible = true

                this.$nextTick(() => {
                    this.inForm = {
                        id:'',
                        empName:'',
                        sex:'',
                        age:'',
                        deptName:'',
                        empDegreeName:''
                    },
                    this.fileList = []
                    this.$refs.inForm.resetFields()
                })
            },

            async submit() {
                if (!this.inForm.id) { //没有id就表示添加
                    const { code, message } = await addUser(this.inForm)
                    if (code === 200) {
                        this.$message.success('添加成功')
                        this.dialogVisible = false
                    } else {
                        this.$message.error(message)
                    }
                } else { //更新
                    const {code, message} = await updateUser(this.inForm)
                    if (code === 200) {
                        this.$message.success('更新成功')
                        this.dialogVisible = false
                        this.getList()
                    } else {
                        this.$message.error(message)
                    }
                }
            },


            /* 切换页码时触发 */
            pageNumberChange(pageNumber) {
                this.pageNumber = pageNumber
                this.getList()
            },

            /* 切换每页显示记录数时触发 */
            pageSizeChange(pageSize) {
                this.pageSize = pageSize
                this.getList()
            },

            /* 查询条件改变时从第一页开始查询 */
            search() {
                this.pageNumber = 1
                this.getList()
            },


            handleEdit(row) {
                this.title = '修改'
                console.log(row)
                //为表单赋值
                this.inForm = row
                this.dialogVisible = true
            },

            /* 查询列表 */
            async getList() {
                console.log(this.pageNumber,this.pageSize,this.queryForm)
                const { data } = await getList(this.pageNumber, this.pageSize, this.queryForm)
                this.tartitionList = data.list
                this.pageNumber = data.pageNum
                this.pageSize = data.pageSize
                this.total = data.total
            },

            /* 删除 */
            deleteUser(id) {
                this.$confirm('是否删除?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    console.log(id);
                    deleteUser(id).then(resp => {
                        const {code, message} = resp
                        if (code === 200) {
                            this.$message.success('删除成功');
                            this.getList()
                        } else {
                            this.$message.error(message);
                        }
                    }).catch(e => {
                        console.log(e)
                    })
                }).catch(() => {
                    this.$message.info('已取消删除');
                });
            },
        },      
        
        mounted() {
            this.getList()
        },
    }
</script>

<style scoped>

</style>