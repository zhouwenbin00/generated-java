package ${package};

<#if imports ??>
    <#list imports as import>
        <#if import ? exists>
import ${import};
        </#if>
    </#list>
</#if>

public class ${className?cap_first} {

<#list fields as field>
    /** ${field.comment!}*/
    private ${field.clazz} ${field.name};

</#list>

<#list fields as field>
    public void set${field.name?cap_first}(${field.clazz} ${field.name}) {
        this.${field.name} = ${field.name};
    }

    <#if field.clazz == "boolean">
    public ${field.clazz} is${field.name?cap_first}() {
        return ${field.name};
    }

    <#else>
    public ${field.clazz} get${field.name?cap_first}() {
        return ${field.name};
    }

    </#if>
</#list>
    @Override
    public String toString() {
        return "${className?cap_first}{" +
<#list fields as field>
    <#if field_index ==0>
            "${field.name}=" + ${field.name} +
    <#elseif field.clazz="byte[]">
            ", ${field.name}=" + Arrays.toString(${field.name}) +
    <#elseif field.clazz="Integer">
            ", ${field.name}=" + ${field.name} +
    <#else >
            ", ${field.name}='" + ${field.name} + '\'' +
    </#if>
</#list>
            '}';
    }
}