package me.jonasws.xp

import com.enonic.xp.resource.ResourceKey
import com.enonic.xp.resource.ResourceService
import com.enonic.xp.script.ScriptValue
import com.enonic.xp.script.bean.BeanContext
import com.enonic.xp.script.bean.ScriptBean
import de.neuland.jade4j.JadeConfiguration

class PugService : ScriptBean {
    val pugConfig = JadeConfiguration()
    lateinit var resourceService: ResourceService

    override fun initialize(context: BeanContext) {
        // Disable template caching if Enonic is running in dev mode
        pugConfig.isCaching = System.getProperty("xp.runMode") != "dev"

        resourceService = context.getService(ResourceService::class.java).get()
        pugConfig.templateLoader = ResourceTemplateLoader(resourceService)
    }

    fun render(view: ResourceKey, model: ScriptValue?): String {
        val resource = resourceService.getResource(view)
        val modelMap = model?.map
        val template = pugConfig.getTemplate(resource.key.toString())
        return pugConfig.renderTemplate(template, modelMap)
    }
}