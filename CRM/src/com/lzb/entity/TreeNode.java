package com.lzb.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TreeNode implements Serializable  {

    private String id;
    private String text;
    private String parentid;
    
    private List<TreeNode> children = new ArrayList<TreeNode>();
    public List<TreeNode> getChildren() {
        return children;
    }
    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
    
    private String iconCls;
   
    
    private String state;//节点状态，'open' 或 'closed'，默认：'open'。
    
    
    private boolean checked;
    
    
    private Map<String, Object> attributes = new HashMap<String, Object>();
    public Map<String, Object> getAttributes() {
        return attributes;
    }
    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public TreeNode(String id, String text, String parentid,
			List<TreeNode> children, String iconCls, String state,
			boolean checked, Map<String, Object> attributes) {
		super();
		this.id = id;
		this.text = text;
		this.parentid = parentid;
		this.children = children;
		this.iconCls = iconCls;
		this.state = state;
		this.checked = checked;
		this.attributes = attributes;
	}
	public TreeNode() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    

    
    
}