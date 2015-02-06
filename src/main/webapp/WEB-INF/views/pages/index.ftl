<#if controllers??>
    <#list controllers as controller>
        ${controller.patternsCondition}
    <br>
    </#list>
</#if>