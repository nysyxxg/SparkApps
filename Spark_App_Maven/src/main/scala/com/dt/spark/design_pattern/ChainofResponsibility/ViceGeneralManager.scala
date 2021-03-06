package com.dt.spark.design_pattern.ChainofResponsibility

/**
  * Created by peng.wang on 2016/6/8.
  */
class ViceGeneralManager(name : String ) extends Leader( name ) {
    override def handleRequest(request: LeaveRequest): Unit = {
        if( request.leaveDays < 20 ) {
            println( "员工" + request.empName + "请假，天数 " + request.leaveDays + " ，理由 " + request.reason  )
            println( "副总经理：" + name + "，审批通过" )
        }else {
            if( nextLeader != null ) {
                nextLeader.handleRequest( request )
            }
        }
    }
}
