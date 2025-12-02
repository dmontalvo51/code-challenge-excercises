package com.dmontalvo;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {

     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int rest=0;
        int sum=0;
        ListNode result=new ListNode();
        ListNode header=result;
        do{
            sum=(int)(rest+l1.val+l2.val)%10;
            rest=(rest+l1.val+l2.val)/10;
            result.val=sum;
            if(l1.next!=null || l2.next!=null){
                result.next=new ListNode();
                result=result.next;
            }
            l1=l1.next;
            l2=l2.next;
        }while(l1!=null && l2!=null);

        while(l1!=null){
            sum=(int)(rest+l1.val)%10;
            rest=(rest+l1.val)/10;
            result.val=sum;
            if(l1.next!=null){
                result.next=new ListNode();
                result=result.next;
            }
            l1=l1.next;
        }
        while(l2!=null){
            sum=(int)(rest+l2.val)%10;
            rest=(rest+l2.val)/10;
            result.val=sum;
            if(l2.next!=null){
                result.next=new ListNode();
                result=result.next;
            }
            l2=l2.next;
        }
        if(rest>0){
            result.next=new ListNode(rest);
        }
        return header;
    }

}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     ListNode(List<Integer> list){
        val=list.get(0);
        if(list.size()>1){
            next=new ListNode(list.subList(1, list.size()));
        }
     }

    boolean verify(List<Integer> list){
        ListNode it=this;
        for(int value:list){
            if(it==null || it.val!=value)
                return false;
            it=it.next;
        };
        return true;
    }

    List<Integer> toList(){
        return toList(null);
    }

    private List<Integer> toList(List<Integer> list){
        if(list==null){
            List<Integer> retList=new ArrayList<>();
            retList.add(val);
            if(next!=null){
                return next.toList(retList);
            }else{
              return retList;
            }
        }else{
            list.add(val);
            if(next!=null){
                return next.toList(list);
            }else{
                return list;
            }
        }
            
    }


 }