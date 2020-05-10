/**
 * dto包主要放如下类型的对象
 * 1. {@link com.dji.dava.dto.Queryable}
 * 2. 针对接口构造的请求参数，推荐以Req结尾。
 * 3. 针对接口构造的返回参数，推荐以Resp结尾。
 * 4. 复杂结构对象（Head&Line || Tree）。
 * 推荐用jsr330注解对请求参数做必要的校验，<br>
 * 推荐将mapping（map2entity）逻辑作为成员方法放在dto内。
 * 与entity大量同名参数时，推荐用 浅克隆{@link com.dji.dava.utils.ConvertUtils} 
 * || 深克隆{@link com.dji.dava.utils.CloneUtills}转换。
 * 
 * @author techni.zhang
 *
 */
package com.yifan.mybatisdemo.dto;

