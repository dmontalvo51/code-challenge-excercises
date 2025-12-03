package com.dmontalvo;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {

     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode result=new ListNode();
       ListNode current=result;
       int carry=0;

       while(l1!=null || l2!=null || carry>0){
         int sum=carry;
         if(l1!=null){
           sum+=l1.val;
           l1=l1.next;
         }
         if(l2!=null){
           sum+=l2.val;
           l2=l2.next;
         }
         carry=sum/10;
         current.val=sum%10;

         if(l1!=null || l2!=null || carry>0){
           current.next=new ListNode();
           current=current.next;
         }
       }
       return result;
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