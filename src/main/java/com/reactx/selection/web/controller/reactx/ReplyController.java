package com.reactx.selection.web.controller.reactx;

import com.reactx.selection.models.base.BaseController;
import com.reactx.selection.models.base.Result;
import com.reactx.selection.models.data.index.ErmReply;
import com.reactx.selection.models.data.index.ErmReplyType;
import com.reactx.selection.service.reactx.ReplyGroupService;
import com.reactx.selection.service.reactx.ReplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/reply")
@Api(value = "reply", description = "快速回复")
public class ReplyController extends BaseController {

    @Autowired
    private ReplyGroupService replyGroupService;
    @Autowired
    private ReplyService replyService;

    @GetMapping("/getAllReply")
    @ApiOperation(value = "获取话术列表", httpMethod = "GET", produces = "application/json;charset=UTF-8")
    @ApiImplicitParam(name = "wechatId", value = "用户微信id", paramType = "query", required = true)
    public Result<Object> getAllReply(String wechatId) {
        List<ErmReply> ermReplies = replyService.queryAllReply(wechatId);
        if (ermReplies==null) return  response(Collections.emptyList());
        Map<String,List> label = new HashMap<>();
        Map<String,Object> qmap = new HashMap<>();
        for(ErmReply e:ermReplies){
            List qList = (List) qmap.get(e.getTypeId().toString()+e.getQuestionId().toString());
            if(qList != null) {
                qList.add(e.getContent());
            }else {
                List qList1 = new ArrayList();
                qList1.add(e.getContent());
                qmap.put(e.getTypeId().toString()+e.getQuestionId().toString(),qList1);
            }
        }

        Map<String,Object> qa = new HashMap<>();
        for(ErmReply e:ermReplies){
            if(qa.get(e.getQ_name()+e.getT_name()) != null){
                continue;
            }
            qa.put(e.getQ_name()+e.getT_name(),"value");
            Map<String,Object> q = new HashMap<>();
            q.put("question",e.getQ_name());
            q.put("content",qmap.get(e.getTypeId().toString()+e.getQuestionId().toString()));
            if(label.get(e.getT_name()) != null){
                label.get(e.getT_name()).add(q);
            }else {
                List list = new ArrayList();
                list.add(q);
                label.put(e.getT_name(),list);
            }
        }

        return response(label);
    }

    @GetMapping("/getReply")
    @ApiOperation(value = "根据话术分组id获取话术", httpMethod = "GET", produces = "application/json;charset=UTF-8")
    @ApiImplicitParam(name = "subGroupId", value = "二级分组id", paramType = "query", required = true)
    public Result<Object> getUserOrders(Integer subGroupId) {
        List<ErmReply> ermReplies = replyService.queryReply(subGroupId);
        if (ermReplies==null) return  response(Collections.emptyList());
        return response(ermReplies);
    }

    @PostMapping("/insertReply")
    @ApiOperation(value = "添加个人话术", httpMethod = "POST", produces = "application/json;charset=UTF-8")
    public Result<Object> insertReply(@RequestBody ErmReply ermReply) {

        try {
            replyService.insertReply(ermReply);
        }catch (Exception e){
            return responseMsg("添加失败,请稍后再试!");
        }
        return response(true);
    }

    @GetMapping("/getGroup")
    @ApiOperation(value = "获取话术分组", httpMethod = "GET", produces = "application/json;charset=UTF-8")
    @ApiImplicitParams({@ApiImplicitParam(name = "classId", value = "分组id(1.企业话术  2.个人话术)", paramType = "query", required = true),
            @ApiImplicitParam(name = "wechatId", value = "用户微信id(个人话术必填)", paramType = "query", required = false)})
    public Result<Object> getGroup(Integer classId,String wechatId) {
        List<ErmReplyType> list = replyGroupService.queryGroup(classId, wechatId);
        return response(list);
    }


    @PostMapping("/insertGroup")
    @ApiOperation(value = "添加话术分组", httpMethod = "POST", produces = "application/json;charset=UTF-8")
    public Result<Object> insertSubGroup(@RequestBody ErmReplyType ermReplyGroup) {

        try {
            replyGroupService.insertSubGroup(ermReplyGroup);
        }catch (Exception e){
            return responseMsg("添加失败,请稍后再试!");
        }
        return response(true);
    }
}
